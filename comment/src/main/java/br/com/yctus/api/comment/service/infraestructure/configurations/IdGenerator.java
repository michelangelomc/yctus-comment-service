package br.com.yctus.api.comment.service.infraestructure.configurations;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochRandomGenerator;
import io.hypersistence.tsid.TSID;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements Serializable {
    @Serial
    private static final long serialVersionUID = -8939123544294884946L;

    private static TimeBasedEpochRandomGenerator idGenerator = Generators.timeBasedEpochRandomGenerator();

    private static final TSID tsIdFac = TSID.Factory.builder().build().generate();

    public static UUID generateTSID() {
        return idGenerator.generate();
    }

    public static TSID generateId() {
        return TSID.Factory.builder().build().generate();
    }
}
