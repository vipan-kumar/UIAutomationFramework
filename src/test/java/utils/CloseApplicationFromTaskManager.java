package utils;

public class CloseApplicationFromTaskManager {
	public static void closeApplication() {
		try {
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"Taskkill /IM kclient.exe /F & exit\"");
		}
		catch(Exception e) {
			System.out.println("Exception in utils/CloseApplicationFromTaskManager class: "+ e.getMessage());
			e.printStackTrace();
		}
	}
}
