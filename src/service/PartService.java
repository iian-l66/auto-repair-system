package service;

import exception.PartNotFoundException;
import model.Part;
import repository.PartRepository;

public class PartService implements CrudService<Part> {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public void add (Part part) {
        partRepository.addPart(part);
    }

    @Override
    public void list () {
        if (partRepository.getPartMap().isEmpty())
            System.out.println("No parts registered yet");
        else
            partRepository.listParts();
    }

    @Override
    public Part get (Long id) {
        if (!partRepository.getPartMap().containsKey(id))
            throw new PartNotFoundException("This part is not registered");

        return partRepository.getPart(id);
    }

    @Override
    public void remove (Long id) {
        if (!partRepository.getPartMap().containsKey(id))
            throw new PartNotFoundException("This part is not registered");

        partRepository.removePart(id);
    }
}
