package AdvancedPersistance;

import java.util.List;

public class JavaServiceFacadeClient {
    public static void main(String[] args) {
        try {
            final JavaServiceFacade javaServiceFacade = new JavaServiceFacade();


            for(PartTimeEmployee partTimeEmployee: (List<PartTimeEmployee>)
            javaServiceFacade.getPartTimeEmployeeFindAll()) {
                javaServiceFacade.removePartTimeEmployee(partTimeEmployee);

            }

            // 177
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
