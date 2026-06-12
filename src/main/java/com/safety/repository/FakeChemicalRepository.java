package com.safety.repository;

import com.safety.model.ChemicalProduct;
import com.safety.model.ChemicalSearchCriteria;
import com.safety.model.ReagentStock;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FakeChemicalRepository implements ChemicalRepository {

    private final AtomicLong stockSequence = new AtomicLong(2);
    private final List<ChemicalProduct> chemicalProducts = new CopyOnWriteArrayList<>();
    private final List<ReagentStock> reagentStocks = new CopyOnWriteArrayList<>();

    public FakeChemicalRepository() {
        chemicalProducts.add(new ChemicalProduct("CHEM101", "에탄올", "64-17-5", "FLAMMABLE"));
        chemicalProducts.add(new ChemicalProduct("CHEM102", "염산", "7647-01-0", "CORROSIVE"));
        chemicalProducts.add(new ChemicalProduct("CHEM103", "수산화나트륨", "1310-73-2", "CORROSIVE"));

        reagentStocks.add(new ReagentStock(
                "STOCK-001",
                "LAB001",
                "CHEM102",
                5.0,
                "L",
                "시약장 A-1",
                LocalDateTime.now()
        ));
    }

    @Override
    public ReagentStock save(ReagentStock reagentStock) {
        if (reagentStock.getStockId() == null || reagentStock.getStockId().isBlank()) {
            reagentStock.setStockId(nextStockId());
        }

        if (reagentStock.getRegisteredAt() == null) {
            reagentStock.setRegisteredAt(LocalDateTime.now());
        }

        reagentStocks.add(reagentStock);
        return reagentStock;
    }

    @Override
    public List<ReagentStock> findByCriteria(ChemicalSearchCriteria criteria) {
        String labId = criteria == null ? null : criteria.getLabId();
        String productId = criteria == null ? null : criteria.getProductId();

        return reagentStocks.stream()
                .filter(stock -> isBlank(labId) || labId.equals(stock.getLabId()))
                .filter(stock -> isBlank(productId) || productId.equals(stock.getProductId()))
                .toList();
    }

    @Override
    public Optional<ChemicalProduct> findProductById(String productId) {
        if (isBlank(productId)) {
            return Optional.empty();
        }

        return chemicalProducts.stream()
                .filter(product -> productId.equals(product.getProductId()))
                .findFirst();
    }

    private String nextStockId() {
        return "STOCK-" + String.format("%03d", stockSequence.getAndIncrement());
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
