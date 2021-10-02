package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = AirLine.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirLine extends BaseEntity<Long> {
    public static final String TABLE_NAME = "airline_table";

    @Column
    private String name;

    @Column
    private String concat_us;

    public AirLine(String name , String concat_us ,AirLineOperator airLineOperator) {
        this.name = name;
        this.concat_us = concat_us;
        this.airLineOperator = airLineOperator;
    }

    @OneToMany(mappedBy = "air_line", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Customer customer;

    @OneToOne(mappedBy = "airLine", cascade = CascadeType.ALL)
    private AirLineOperator airLineOperator;

}
