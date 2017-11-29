package dom.test.model;

import dom.test.model.dto.TestDto;
import rx.Observable;

/**
 * Created by dementr on 29.11.2017.
 */

public interface Model {
    Observable<TestDto> getRecords();
}
