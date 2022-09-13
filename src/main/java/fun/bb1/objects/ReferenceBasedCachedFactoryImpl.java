package fun.bb1.objects;

import java.lang.ref.SoftReference;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.defineables.ICachedFactory;
import fun.bb1.objects.defineables.IFactory;

public class ReferenceBasedCachedFactoryImpl<T> implements ICachedFactory<T> {
	
	private @NotNull SoftReference<T> ref;
	private final @NotNull IFactory<T> factory;
	
	private ReferenceBasedCachedFactoryImpl(final @NotNull IFactory<T> factory) {
		this.factory = factory;
		this.ref = new SoftReference<T>(this.factory.create());
	}
	
	@Override
	public @NotNull T create() {
		if (this.ref.get() == null) {
			this.ref = new SoftReference<T>(this.factory.create());
		}
		return this.ref.get();
	}
	
}
