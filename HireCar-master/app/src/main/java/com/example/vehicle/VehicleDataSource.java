package com.example.vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDataSource {
    private static VehicleDataSource instance = null;
    List<VehicleData> vehicles;

    private VehicleDataSource() {

        vehicles = new ArrayList<>();
        String[]  typeArray = new String[] {"Corolla","Elantra","Civic","Cx-30","Charger","Cherokee"};
        String[] brandArray = new String[] {"Toyota","Hyundai","Honda","Mazda","dodge ","Jeep"};
        String[] modelArray = new String[] {"M1","E1","X6","M2","E2","X8"};
        String[]  yearArray = new String[] {"2019","2018","2018","2017","2017","2016"};
        String[] colorArray = new String[] {"Black","Red","Black","Red","White","Black"};
        String[] stateArray = new String[] {"Rental","Return","Rental","Reservation","Reservation","Return"};
        String[] sdateArray = new String[] {"10/27/2019","10/26/2019","10/26/2019","10/29/2019","10/29/2019","10/23/2019"};
        String[] edatdArray = new String[] {"5 Days","10/26/2019","12 Days","10/31/2019","11/5/2019","10/23/2019"};

        for (int i=0;i<=5;i++ )
        {

            VehicleData vehicle = new VehicleData();

            vehicle.id = i+1;
            vehicle.type = typeArray[i];
            vehicle.brand = brandArray[i];
            vehicle.model = modelArray[i];
            vehicle.year = yearArray[i];
            vehicle.color = colorArray[i];
            vehicle.licenseplate = "ABC 10" + i;
            vehicle.state = stateArray[i];
            vehicle.sdate = sdateArray[i];
            vehicle.edate = edatdArray[i];

                vehicles.add(vehicle);
        }

    }

    static VehicleDataSource getInstance() {
        if (instance == null) {
            instance = new VehicleDataSource();
        }
        return instance;
    }
}

