package first.repository;

import first.database.IDatabase;
import first.games.whowantotbeamillionaire.MillionaireGameState;

public class MillionaireRepository extends Repository<MillionaireGameState> {
    public MillionaireRepository(IDatabase database) {
        super(MillionaireGameState.class, database);
    }
}
