    package com.ruquet.nbaapp.DTO;
    import com.ruquet.nbaapp.Model.Player;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import java.util.List;

    @Getter
    @Setter
    @NoArgsConstructor
    public class TeamDetailDTO {

        private Integer id;
        private String name;
        private List<PlayerDTO> players;

        public TeamDetailDTO(Integer id, String name, List<PlayerDTO> players) {
            this.id = id;
            this.name = name;
            this.players = players;
        }
    }
