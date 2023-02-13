package hierarchy;

import java.util.List;

public interface SoftwareMapper {
    Software getInfoById(long id);
    List<Software> getAllInfo();
}
