package service;

import exception.PartNotFoundException;
import model.Part;
import repository.PartRepository;

public class PartService {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public void addPart (Part part) {
        partRepository.addPart(part);
    }

    public void listParts () {
        if (partRepository.getPartMap().isEmpty())
            System.out.println("No parts registered yet");
        else
            partRepository.listParts();
    }

    public Part getPart (Long id) {
        if (!partRepository.getPartMap().containsKey(id))
            throw new PartNotFoundException("This part is not registered");

        return partRepository.getPart(id);
    }

    public void removePart (Long id) {
        if (!partRepository.getPartMap().containsKey(id))
            throw new PartNotFoundException("This part is not registered");

        partRepository.removePart(id);
    }
}
