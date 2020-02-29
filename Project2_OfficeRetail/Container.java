/**
 * 
 * @author Alec Felix
 * CMSC 204 Prof. Thai
 * Project 2: Office Retail
 * 
 *
 */
public class Container implements ContainerInterface{
	private MyStack<DonationPackage> container;
	
	/**
	 * Default constructor. Creates Contiainer stack with default size
	 */
	public Container() {
		container = new MyStack<DonationPackage>();
	}//default constructor
	
	/**
	 * Creates container stack with the given size.
	 * @param size
	 */
	public Container(int size) {
		container = new MyStack<DonationPackage>(size);
	}//constructor
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if(!container.push(dPackage))
			throw new ContainerException("The Container is Full");
		
		return true;
	}//loadContainer

	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if(container.isEmpty())
			throw new ContainerException("The Container is Empty");
		
		return container.pop();
	}//removePackageFromContainer
	
	/**
	 * Check if Container is empty or not
	 * @return true if empty
	 */
	public boolean containerEmpty() {
		return container.isEmpty();
	}//containerEmpty

	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic stack returns is an array of 
	 * type Object , i.e., Object[] temp. But since the individual elements of the array are still DonationPackages,
	 * we can copy them one by one into a new array	of type DonationPackage and cast each one to DonationPackage. 
	 * So create a new array of DonationPackages of the same length as temp, run a for-loop that casts each element 
	 * of temp to DonationPackage, and copies it to the corresponding position in the new array.  Then return the new array.
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	public DonationPackage[] toArrayPackage() {
		DonationPackage[] dpckg = new DonationPackage[container.size()];
		Object[] tmp = container.toArray();
		
		for(int i = 0; i < tmp.length;i++) {
			dpckg[i] = (DonationPackage) tmp[i];
		}
		return dpckg;
	}//toArrayPackage

}//Container
