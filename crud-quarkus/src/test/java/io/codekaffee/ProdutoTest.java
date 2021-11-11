package io.codekaffee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;

import org.junit.jupiter.api.Test;

import io.codekaffee.models.Produto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;



@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProdutoTest {

    @Test
    @DataSet("products.yml")
    public void testUm() {
        assertEquals(1, Produto.count());
    }

}

