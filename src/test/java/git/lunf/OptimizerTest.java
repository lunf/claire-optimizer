/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git.lunf;

import git.lunf.helper.CsvReader;
import git.lunf.errors.EmptyProjectException;
import git.lunf.errors.OptimizationFailedException;
import git.lunf.model.Panel;
import git.lunf.model.Project;
import git.lunf.model.StockSheet;
import git.lunf.helper.Utils;
import git.lunf.model.PartCncRun;
import git.lunf.optimizer.GAOptimizationStrategy;
import git.lunf.optimizer.OptimizationResult;
import git.lunf.optimizer.OptimizationStrategy;
import git.lunf.optimizer.Optimizer;
import git.lunf.testing.PartData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rmuehlba
 */
public class OptimizerTest {


    private CsvReader csvReader;

    public OptimizerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        csvReader = new CsvReader();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of optimize method, of class Optimizer.
     */
    @org.junit.Test
    public void testOptimize() throws Exception {

        ///Users/cuongnguyen/Documents/github/cutlet/CutletLib/src/test/resources/R6W-1.csv
        List<PartCncRun> partCncRunList = csvReader.readPartCncCsvFile("RNY-1.csv");

        System.out.println("Input part size: " + partCncRunList.size());

        HashMap<StockSheet, List<Panel>> sheetAndParts = new HashMap<>();
        List<StockSheet> sheetList = Utils.getMaterialSheet(partCncRunList);

        System.out.println("Material size " + sheetList.size());

        for (StockSheet stockSheet: sheetList) {

            List<Panel> allSheetsAndPartByMaterial = Utils.groupedPartByMaterial(stockSheet, partCncRunList);

            PartData partData = new PartData(allSheetsAndPartByMaterial);

            System.out.println("optimize for material : " + stockSheet.getMaterial().getName());
            System.out.println("optimize for parts : " + allSheetsAndPartByMaterial.size());
            optimise(partData);

            System.out.println(" ========================================== " );
        }



    }

    private void optimise(PartData partData) throws EmptyProjectException, OptimizationFailedException {


        Project project = partData.getData();

        long start = System.currentTimeMillis();
        OptimizationStrategy strategy = new GAOptimizationStrategy();
        //OptimizationStrategy strategy = new NaiiveOptimizationStrategy();
        Optimizer instance = new Optimizer();
        OptimizationResult result = instance.optimize(project, strategy);

        System.out.println("Number of sheets: " + result.getStats().getNumberOfLayouts());
        System.out.println("Waste per : " + result.getStats().getWastagePercent() + " %");

//        for (Layout layout: result.getLayouts()) {
//            System.out.println(layout.getSheet().getMaterial().getName() + "  - " + layout.getId() + " " +layout.getNumberOfPlacedPanels());
//        }
        System.out.println("Complete with " + String.format("%d in millis seconds", (System.currentTimeMillis() - start)));
    }
    
}
