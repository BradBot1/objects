package fun.bb1.objects.container;

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
 * An implementation of {@link IContainer} that is immutable
 * 
 * @apiNote The contained object may have its state modified
 * 
 * @author BradBot_1
 */
public final class ImmutableContainer<T> implements IImmutable, IContainer {
	
	private final @Nullable T t;
	
	public ImmutableContainer(@Nullable final T obj) {
		this.t = obj;
	}
	
	@Override
	public boolean throwsOnModification() {
		return false;
	}

	@Override
	public @Nullable Object getContained() {
		return this.t;
	}
	
}
