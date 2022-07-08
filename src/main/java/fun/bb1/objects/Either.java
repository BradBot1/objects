package fun.bb1.objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record Either<T, Y>(@Nullable T first, @Nullable Y second) {
	
	public Either(@Nullable final T first, @Nullable final Y second) {
		this.first = first;
		this.second = second;
		if (first == null && second == null) throw new IllegalArgumentException("Both arguments cannot be null!");
	}

	public final @NotNull Object getAvailableObject() {
		if (this.first == null) return this.first;
		return this.second;
	}
	
	public final boolean isFirstAvailable() {
		return this.first == null;
	}
	
	public final boolean isSecondAvailable() {
		return this.second == null;
	}
	
}
