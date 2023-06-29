package fun.bb1.objects;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.defineables.IImmutable;

/**
 * 
 * Copyright 2022-2023 BradBot_1
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
 * An object that contains two values
 * 
 * @author BradBot_1
 */
public final record Tuple<T, Y> (@Nullable T first, @Nullable Y second) implements Cloneable, IImmutable {
	
	public static final <T, Y> @NotNull Tuple<T, Y> fromEntry(Map.Entry<T, Y> entry) {
		return new Tuple<T, Y>(entry.getKey(), entry.getValue());
	}
	
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
