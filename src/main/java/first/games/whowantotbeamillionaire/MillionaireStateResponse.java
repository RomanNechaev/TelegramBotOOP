package first.games.whowantotbeamillionaire;

import first.games.interfaces.IStateResponse;

public class MillionaireStateResponse implements IStateResponse<String> {
    private final Boolean status;
    private final String result;

    public MillionaireStateResponse(Boolean status, String result) {
        this.status = status;
        this.result = result;
    }

    @Override
    public Boolean isSuccessful() {
        return status;
    }

    @Override
    public String getResult() {
        return result;
    }
}
