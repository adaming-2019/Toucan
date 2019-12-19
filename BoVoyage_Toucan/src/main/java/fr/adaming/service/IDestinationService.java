
package fr.adaming.service;

	import java.util.List;

	import javax.print.attribute.standard.Destination;

	public interface IDestinationService {

		public List<Destination> getAll();
		
		public Destination getById(int Did);
		
		public Destination add(Destination dIn);
		
		public Destination update (Destination dIn);
		
		public void delete(int id);
		
		
	}
