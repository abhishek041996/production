package Apis;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

public class firebaseDelete {
	public int test() {
        try {
            // Initialize the Firebase SDK using the service account key file
            FileInputStream serviceAccount = new FileInputStream("C:\\Windows\\firebaseFile.json");
            @SuppressWarnings("deprecation")
			FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
            
          // The email of the user to delete
            String email = "abhiamilkanthwar96@gmail.com";

         // Retrieve the user by email
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);

         // Get the UID of the user
            String uid = userRecord.getUid();
            
        // Delete the user
            FirebaseAuth.getInstance().deleteUser(uid);
            System.out.println("Successfully deleted user: " + uid);

        } catch (FirebaseAuthException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error initializing Firebase: " + e.getMessage());
        }
		return 0;
    }
}


