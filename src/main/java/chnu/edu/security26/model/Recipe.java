/**
 * @author Anastasiia Klyvchuk
 * @project security-26
 * @date 21.09.2026
 */
package chnu.edu.security26.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    private String id;
    private String name;
    private String description;
    private int cookingTimeMinutes;
    private String difficulty;
}
