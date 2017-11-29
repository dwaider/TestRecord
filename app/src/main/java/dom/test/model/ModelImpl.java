package dom.test.model;

import javax.inject.Inject;

import dom.test.App;
import dom.test.model.api.ApiInterface;
import dom.test.model.dto.TestDto;
import rx.Observable;

/**
 * Created by dementr on 29.11.2017.
 */

public class ModelImpl implements Model {
    @Inject
    protected ApiInterface apiInterface;

    public ModelImpl() {
        App.getComponent().inject(this);
    }

    @Override
    public Observable<TestDto> getRecords() {
        return apiInterface.getRecords();
    }
}
