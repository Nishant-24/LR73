package com.argus.oth.bulk.load.background.task.service.util;

import static java.util.Spliterators.spliterator;
import static java.util.stream.StreamSupport.stream;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author Davy
 */
public class FixedBatchSpliteratorWrapper<T> implements Spliterator<T> {

	public static <T> Stream<T> toFixedBatchStream(Stream<T> in, int batchSize) {
		return stream(new FixedBatchSpliteratorWrapper<>(in.spliterator(), batchSize), true);
	}

	public FixedBatchSpliteratorWrapper(Spliterator<T> toWrap, int batchSize) {
		this(toWrap, toWrap.estimateSize(), batchSize);
	}

	public FixedBatchSpliteratorWrapper(Spliterator<T> toWrap, long est, int batchSize) {
		final int c = toWrap.characteristics();

		_characteristics = (c & SIZED) != 0 ? c | SUBSIZED : c;

		_spliterator = toWrap;
		_est = est;
		_batchSize = batchSize;
	}

	@Override
	public int characteristics() {
		return _characteristics;
	}

	@Override
	public long estimateSize() {
		return _est;
	}

	@Override
	public void forEachRemaining(Consumer<? super T> action) {
		_spliterator.forEachRemaining(action);
	}

	@Override
	public Comparator<? super T> getComparator() {
		if (hasCharacteristics(SORTED))

			return null;

		throw new IllegalStateException();
	}

	@Override
	public boolean tryAdvance(Consumer<? super T> action) {
		return _spliterator.tryAdvance(action);
	}

	@Override
	public Spliterator<T> trySplit() {
		final HoldingConsumer<T> holder = new HoldingConsumer<>();

		if (!_spliterator.tryAdvance(holder))

			return null;
		final Object[] a = new Object[_batchSize];
		int j = 0;

		do {
			a[j] = holder._value;
		}
		while ((++j < _batchSize) && tryAdvance(holder));

		if (_est != Long.MAX_VALUE)
			_est -= j;

		return spliterator(a, 0, j, characteristics());
	}

	private final int _batchSize;
	private final int _characteristics;
	private long _est;
	private final Spliterator<T> _spliterator;

	static final class HoldingConsumer<T> implements Consumer<T> {

		Object _value;

		@Override
		public void accept(T value) {
			_value = value;
		}

	}

}