package model;

import javax.persistence.*;
@MappedSuperclass
public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 100000;

    private int id;

    public AbstractBaseEntity(int id) {
        this.id = id;
    }

    public AbstractBaseEntity() { }

    @Id
    @SequenceGenerator(name = "global_seq",
            sequenceName = "global_seq",
            allocationSize = 1,
            initialValue = START_SEQ
    )
    @GeneratedValue(strategy = GenerationType.AUTO
            ,generator = "global_seq"
    )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
