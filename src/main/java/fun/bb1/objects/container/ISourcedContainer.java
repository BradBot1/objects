package fun.bb1.objects.container;

public sealed interface ISourcedContainer extends IContainer permits SourcedContainer<Object> {
	
}