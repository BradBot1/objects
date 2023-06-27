package fun.bb1.objects.container;

import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
 * An implementation of {@link IValidatedContainer}
 * 
 * @author BradBot_1
 */
public final class ValidatedContainer<T> implements IValidatedContainer {
	
	private @Nullable T t;
	/**
	 * The predicate that manages if the state is valid,
	 * when it returns false the state should be cleared
	 */
	private final @NotNull Predicate<T> validationPredicate;
	
	public ValidatedContainer(@Nullable final T obj, final @NotNull Predicate<@Nullable T> validationPredicate) {
		this.t = obj;
		this.validationPredicate = validationPredicate;
	}
	
	@Override
	public @Nullable T getContained() {
		this.performManagement();
		return this.t;
	}

	@Override
	public void performManagement() {
		if (!this.validationPredicate.test(this.t)) this.t = null;
	}
	
}
