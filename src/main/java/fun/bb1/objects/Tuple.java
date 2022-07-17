package fun.bb1.objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.defineables.IImmutable;

public final record Tuple<T, Y> (@Nullable T first, @Nullable Y second) implements Cloneable, IImmutable {

	public final @NotNull Tuple<Y, T> reverse() {
		return new Tuple<Y, T>(this.second, this.first);
	}
	
	public final <T2> @NotNull Tuple<T2, Y> setFirst(@Nullable final T2 newFirst) {
		return new Tuple<T2, Y>(newFirst, this.second);
	}
	
	public final <Y2> @NotNull Tuple<T, Y2> setSecond(@Nullable final Y2 newSecond) {
		return new Tuple<T, Y2>(this.first, newSecond);
	}
	
	@Override
	public final @NotNull Tuple<T, Y> clone() {
		return new Tuple<T, Y>(this.first, this.second);
	}
	
}
