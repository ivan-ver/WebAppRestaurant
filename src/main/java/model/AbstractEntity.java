package model;


import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    public static final int START_SEQ = 100000;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "global_seq",
            sequenceName = "global_seq",
            allocationSize = 1,
            initialValue = START_SEQ
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "global_seq")
    protected Integer id;

    public AbstractEntity() {}

    public AbstractEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
