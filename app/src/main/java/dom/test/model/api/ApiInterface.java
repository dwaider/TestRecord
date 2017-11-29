package dom.test.model.api;

import dom.test.model.dto.TestDto;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by dementr on 29.11.2017.
 */

public interface ApiInterface {
    @GET("search-items")
    Observable<TestDto> getRecords();
}
