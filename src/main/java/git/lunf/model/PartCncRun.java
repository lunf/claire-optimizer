package git.lunf.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class PartCncRun {
    /**
     *
     */

    @CsvBindByPosition(position = 0)
    private int partIndex;

    @CsvBindByPosition(position = 1)
    private int partId;

    @CsvBindByPosition(position = 2)
    private int partQty;

    @CsvBindByPosition(position = 3)
    private String partName;

    @CsvBindByPosition(position = 4)
    private String partInternalName;

    @CsvBindByPosition(position = 5)
    private String partWidthString;

    @CsvBindByPosition(position = 6)
    private String partLengthString;

    @CsvBindByPosition(position = 7)
    private double partWidth;

    @CsvBindByPosition(position = 8)
    private double partLength;

    @CsvBindByPosition(position = 9)
    private String partZlpNameZeroOr90;

    @CsvBindByPosition(position = 10)
    private String partZlpName180Or270;

    @CsvBindByPosition(position = 11)
    private String partComment;

    @CsvBindByPosition(position = 12)
    private String partPrimaryEdge;

    @CsvBindByPosition(position = 13)
    private String partMirror;

    @CsvBindByPosition(position = 14)
    private String partFrProgram;

    @CsvBindByPosition(position = 15)
    private String partBaProgram;

    @CsvBindByPosition(position = 16)
    private String partFrMirror;

    @CsvBindByPosition(position = 17)
    private String partBaMirror;

    @CsvBindByPosition(position = 18)
    private String partFrBarCode;

    @CsvBindByPosition(position = 19)
    private String partBaBarCode;

    @CsvBindByPosition(position = 20)
    private String partFrWorkZone;

    @CsvBindByPosition(position = 21)
    private String partBaWorkZone;

    @CsvBindByPosition(position = 22)
    private String partLeBarCode;

    @CsvBindByPosition(position = 23)
    private String partRiBarCode;

    @CsvBindByPosition(position = 24)
    private String partToBarCode;

    @CsvBindByPosition(position = 25)
    private String partBoBarCode;

    @CsvBindByPosition(position = 26)
    private String partShaped;

    @CsvBindByPosition(position = 27)
    private String partGangBore;

    @CsvBindByPosition(position = 28)
    private String partHorizontalBore;

    @CsvBindByPosition(position = 29)
    private String partPriMachineID;

    @CsvBindByPosition(position = 30)
    private String partSecMachineID;

    @CsvBindByPosition(position = 31)
    private String partHorMachineID;

    @CsvBindByPosition(position = 32)
    private String partCutMachineID;

    @CsvBindByPosition(position = 33)
    private boolean partHasBanding;

    @CsvBindByPosition(position = 34)
    private String partBanding;

    @CsvBindByPosition(position = 35)
    private String partBandingCode;

    @CsvBindByPosition(position = 36)
    private String partBandingFlags;

    @CsvBindByPosition(position = 37)
    private String partIntBandBarCode;

    @CsvBindByPosition(position = 38)
    private String partExtBandBarCode;

    @CsvBindByPosition(position = 39)
    private String partFinishFace;

    @CsvBindByPosition(position = 40)
    private String partFinishBack;

    @CsvBindByPosition(position = 41)
    private String partFinishEdge;

    @CsvBindByPosition(position = 42)
    private String partImageLocationAndName;

    @CsvBindByPosition(position = 43)
    private String roomID;

    @CsvBindByPosition(position = 44)
    private String roomName;

    @CsvBindByPosition(position = 45)
    private int assemblyID;

    @CsvBindByPosition(position = 46)
    private int assemblyNumber;

    @CsvBindByPosition(position = 47)
    private String assemblyName;

    @CsvBindByPosition(position = 48)
    private double assemblyWidth;

    @CsvBindByPosition(position = 49)
    private double assemblyHeight;

    @CsvBindByPosition(position = 50)
    private double assemblyDepth;

    @CsvBindByPosition(position = 51)
    private int assemblyWallNo;

    @CsvBindByPosition(position = 52)
    private String assemblyClass;

    @CsvBindByPosition(position = 53)
    private String assemblyType;

    @CsvBindByPosition(position = 54)
    private String assemblyDescription;

    @CsvBindByPosition(position = 55)
    private String assemblyComment;

    @CsvBindByPosition(position = 56)
    private int jobID;

    @CsvBindByPosition(position = 57)
    private String jobName;

    @CsvBindByPosition(position = 58)
    private String jobDescription;

    @CsvBindByPosition(position = 59)
    private String jobComments;

    @CsvBindByPosition(position = 60)
    private String jobFilePath;

    @CsvBindByPosition(position = 61)
    private String custName;

    @CsvBindByPosition(position = 62)
    private String custAddress;

    @CsvBindByPosition(position = 63)
    private String custCity;

    @CsvBindByPosition(position = 64)
    private String custState;

    @CsvBindByPosition(position = 65)
    private String custZip;

    @CsvBindByPosition(position = 66)
    private String custContact;

    @CsvBindByPosition(position = 67)
    private String custEmail;

    @CsvBindByPosition(position = 68)
    private String custFax;

    @CsvBindByPosition(position = 69)
    private String custPhone;

    @CsvBindByPosition(position = 70)
    private String custMobile;

    @CsvBindByPosition(position = 71)
    private String dateMeasure;

    @CsvBindByPosition(position = 72)
    private String dateDetail;

    @CsvBindByPosition(position = 73)
    private String dateProduction;

    @CsvBindByPosition(position = 74)
    private String dateDelivery;

    @CsvBindByPosition(position = 75)
    private String dateDeposit;

    @CsvBindByPosition(position = 76)
    private String dateInstall;

    @CsvBindByPosition(position = 77)
    private String dateFinalPayment;

    @CsvBindByPosition(position = 78)
    private long materialID;

    @CsvBindByPosition(position = 79)
    private long matDBID;

    @CsvBindByPosition(position = 80)
    private int matPatNo;

    @CsvBindByPosition(position = 81)
    private int matPartIndex;

    @CsvBindByPosition(position = 82)
    private int matPatIndex;

    @CsvBindByPosition(position = 83)
    private String matName;

    @CsvBindByPosition(position = 84)
    private double matWidth;

    @CsvBindByPosition(position = 85)
    private double matLength;

    @CsvBindByPosition(position = 86)
    private double matThick;

    @CsvBindByPosition(position = 87)
    private boolean matGrain;

    @CsvBindByPosition(position = 88)
    private String matTextureFace;

    @CsvBindByPosition(position = 89)
    private String matTextureBack;

    @CsvBindByPosition(position = 90)
    private String matTextureEdge;

}
