package git.lunf.helper;


import git.lunf.material.Wood;
import git.lunf.model.Dimension;
import git.lunf.model.Panel;
import git.lunf.model.PartCncRun;
import git.lunf.model.StockSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<StockSheet> getMaterialSheet(final List<PartCncRun> partCncRunList) {

        // filter to get material of sheet
        List<PartCncRun> rawMaterialPartList = new ArrayList<>(partCncRunList);

        // remove duplicate material
        for (int index = 0; index < rawMaterialPartList.size() - 1; index++) {
            String matName = rawMaterialPartList.get(index).getMatName();
            rawMaterialPartList.subList(index + 1, rawMaterialPartList.size()).removeIf(next -> matName.equalsIgnoreCase(next.getMatName()));
        }


        List<StockSheet> sheetList = rawMaterialPartList.stream().map(part -> {
            double thickness = part.getMatThick();
            double matLength = part.getMatLength();
            double matWidth = part.getMatWidth();
            String matName = part.getMatName();
            boolean hasGrain = part.isMatGrain();

            Wood wood = new Wood(matName);


            StockSheet stockSheet = new StockSheet(matName, wood, new Dimension(matLength, matWidth), thickness, hasGrain);

            return stockSheet;
        }).collect(Collectors.toList());

        return sheetList;

    }

    private static boolean isIdenticalMaterial(PartCncRun part, StockSheet stockSheet) {
        boolean isIdenticalMaterial = true;

        double thickness = part.getMatThick();
        double matLength = part.getMatLength();
        double matWidth = part.getMatWidth();
        String matName = part.getMatName();

        double sheetThickness = stockSheet.getThickness();
        double sheetLength = stockSheet.getDimension().getLength();
        double sheetWidth = stockSheet.getDimension().getWidth();
        String sheetMatName = stockSheet.getMaterial().getName();


        if (matLength != sheetLength || matWidth != sheetWidth || thickness != sheetThickness || !sheetMatName.equalsIgnoreCase(matName)) {
            isIdenticalMaterial = false;
        }

        return isIdenticalMaterial;
    }
    public static List<Panel> allSheetsAndPartByMaterial(List<StockSheet> stockSheetList, List<PartCncRun> partCncRunList) {

        List<Panel> allSheetAndParts = new ArrayList<>();

        for (StockSheet stockSheet : stockSheetList) {

            List<Panel> filteredData = groupedPartByMaterial(stockSheet, partCncRunList);

            allSheetAndParts.addAll(filteredData);
        }

        return allSheetAndParts;
    }

    public static List<Panel> groupedPartByMaterial(StockSheet stockSheet, List<PartCncRun> partCncRunList) {

        List<Panel> parts = new ArrayList<Panel>();
        for (PartCncRun part : partCncRunList) {

            // If not same material --> no processing
            if (!isIdenticalMaterial(part, stockSheet)) {
                continue;
            }

            double partWidth = part.getPartWidth();
            double partLength = part.getPartLength();
            String partName = part.getPartName();
            boolean canRotate = !part.isMatGrain();
            int partQty = part.getPartQty();

            Panel panel = new Panel(stockSheet, new Dimension(partLength, partWidth), partName, false, 1);

            parts.add(panel);

        }

        return parts;
    }
}
