package pl.javastart.springjpaboot.model.klucz_zlozony;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PersonKey implements Serializable {
    private static final long serialVersionUID=1L;

    private String firstName;

    private String lastName;

    private String telephone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonKey personKey = (PersonKey) o;
        return Objects.equals(firstName, personKey.firstName) &&
                Objects.equals(lastName, personKey.lastName) &&
                Objects.equals(telephone, personKey.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, telephone);
    }
}
