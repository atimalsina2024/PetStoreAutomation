package api.checksyntax;

import java.io.IOException;

import api.utilities.PetDataProvider;

public class DataProviderTest {

	public static void main(String[] args) throws IOException {
		PetDataProvider dp = new PetDataProvider();
		String [][] test = dp.getAllPetData();
		
		System.out.println(test[0].length);
		
		}
	}

