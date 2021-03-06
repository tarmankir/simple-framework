package bodies;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ErrorUserBody {

        @SerializedName("type")
        private String type;

        @SerializedName("message")
        private String message;

        @SerializedName("name")
        private String name;
}