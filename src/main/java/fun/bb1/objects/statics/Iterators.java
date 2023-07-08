package fun.bb1.objects.statics;

import java.util.Iterator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.defineables.IStaticMethodsOnly;

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
 * A simple class to implement iterators
 * 
 * @author BradBot_1
 */
public final class Iterators implements IStaticMethodsOnly {
	
	private Iterators() { }
	
	public static final <E> @NotNull Iterator<E> fromArrayClone(@Nullable final E[] array) {
		if (array == null || array.length == 0) return empty();
		return fromArray(array.clone());
	}
	
	public static final <E> @NotNull Iterator<E> fromArray(@Nullable final E[] array) {
		if (array == null || array.length == 0) return empty();
		return new ArrayIterator<E>(array);
	}
	
	public static final <E> @NotNull Iterator<E> empty(@Nullable final Class<E> iteratorType) {
		return empty();
	}
	
	public static final <E> @NotNull Iterator<E> empty() {
		return new EmptyIterator<E>();
	}
	
	static final class ArrayIterator<E> implements Iterator<E> {
		
		private final @NotNull E[] array;
		private int index = 0;
		
		ArrayIterator(@NotNull final E[] array) {
			this.array = array;
		}
		
		@Override
		public final boolean hasNext() {
			return this.index < this.array.length;
		}

		@Override
		public final @Nullable E next() {
			if (!this.hasNext()) return null;
			return this.array[this.index++];
		}
		
	}
	
	static final class EmptyIterator<E> implements Iterator<E> {
		
		EmptyIterator() { }
		
		@Override
		public final boolean hasNext() {
			return false;
		}

		@Override
		public final @Nullable E next() {
			return null;
		}
		
	}
	
}
