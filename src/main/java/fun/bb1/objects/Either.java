package fun.bb1.objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.defineables.IImmutable;

/**
 * 
 * Copyright 2022 BradBot_1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * An object that contains one of the two allowed values
 * 
 * @author BradBot_1
 */
public record Either<T, Y>(@Nullable T first, @Nullable Y second) implements IImmutable {
	
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
