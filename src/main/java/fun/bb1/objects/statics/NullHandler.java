package fun.bb1.objects.statics;

import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.defineables.IStaticMethodsOnly;

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
 * A collection of static methods to make dealing with null easier
 * 
 * @author BradBot_1
 */
public final class NullHandler implements IStaticMethodsOnly {
	
	private NullHandler() { }
	
	public static final <T> @NotNull T defaultIfNull(@Nullable final T value, @NotNull final T fallback) {
		return value == null ? fallback : value;
	}
	
	public static final <T> @NotNull T generateIfNull(@Nullable final T value, @NotNull final Supplier<T> fallback) {
		return value == null ? fallback.get() : value;
	}
	
	public static final <T> @NotNull T throwIfNull(@Nullable final T value, @NotNull final Supplier<RuntimeException> toThrow) {
		if (value == null) throw toThrow.get();
		return value;
	}
	
	public static final <T> @NotNull T throwIfNull(@Nullable final T value) {
		return throwIfNull(value, () -> new NullPointerException("Provied value failed check"));
	}
	
	
	
}
