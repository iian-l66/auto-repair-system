package repository;

import model.Part;
import java.util.HashMap;
import java.util.Map;

public class PartRepository {
    private Map<Long, Part> partMap = new HashMap<>();

    public Part getPart (Long id) {
        return partMap.get(id);
    }

    public void listParts () {
        partMap.forEach((key, value) -> System.out.println(value));
    }

    public void addPart (Part part) {
        partMap.put(part.getId(), part);
    }

    public void removePart(Long id) {
        partMap.remove(id);
    }

    public Map<Long, Part> getPartMap() {
        return partMap;
    }
}