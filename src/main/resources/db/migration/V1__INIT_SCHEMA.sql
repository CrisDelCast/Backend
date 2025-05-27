CREATE TABLE pool (
                      id UUID PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      configuration_id UUID,
                      starting_date TIMESTAMP NOT NULL,
                      ending_date TIMESTAMP NOT NULL,
                      phase INTEGER,
                      state VARCHAR(255) NOT NULL,
                      created_at TIMESTAMP DEFAULT NOW(),
                      updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE pool_configuration (
                                    id UUID PRIMARY KEY,
                                    pool_id UUID UNIQUE,
                                    champions_win_points NUMERIC NOT NULL,
                                    second_place_win_points NUMERIC NOT NULL,
                                    third_place_win_points NUMERIC NOT NULL,
                                    winner_team_win_points NUMERIC NOT NULL,
                                    draw_team_win_points NUMERIC NOT NULL,
                                    total_yellow_cards_win_points NUMERIC NOT NULL,
                                    total_red_cards_win_points NUMERIC NOT NULL,
                                    total_local_goals_win_points NUMERIC NOT NULL,
                                    total_visiting_goal_win_points NUMERIC NOT NULL
);

CREATE TABLE team (
                      id UUID PRIMARY KEY,
                      pool_id UUID,
                      name VARCHAR(255) NOT NULL,
                      short_name VARCHAR(100),
                      flag VARCHAR(255),
                      phase INTEGER,
                      state VARCHAR(255) NOT NULL,
                      created_at TIMESTAMP DEFAULT NOW(),
                      updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE "user" (
                        id UUID PRIMARY KEY,
                        pool_id UUID,
                        id_number VARCHAR(100) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        phone VARCHAR(50),
                        age INTEGER,
                        name VARCHAR(255),
                        nickname VARCHAR(100),
                        password VARCHAR(255),
                        photo TEXT,
                        role VARCHAR(100),
                        otp VARCHAR(50),
                        points NUMERIC,
                        state VARCHAR(255) NOT NULL,
                        created_at TIMESTAMP DEFAULT NOW(),
                        updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE "match" (
                         id UUID PRIMARY KEY,
                         pool_id UUID,
                         home_team UUID,
                         visitor_team UUID,
                         match_date TIMESTAMP NOT NULL,
                         home_goals INTEGER,
                         visitor_goals INTEGER,
                         home_yellow_cards INTEGER,
                         home_red_cards INTEGER,
                         visitor_yellow_cards INTEGER,
                         visitor_red_cards INTEGER,
                         phase INTEGER,
                         state VARCHAR(255) NOT NULL,
                         created_at TIMESTAMP DEFAULT NOW(),
                         updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE match_bet (
                           id UUID PRIMARY KEY,
                           pool_id UUID,
                           match_id UUID,
                           user_id UUID,
                           winner_team_id UUID,
                           home_goals INTEGER,
                           visitor_goals INTEGER,
                           home_yellow_cards INTEGER,
                           home_red_cards INTEGER,
                           visitor_yellow_cards INTEGER,
                           visitor_red_cards INTEGER,
                           rated BOOLEAN,
                           points NUMERIC,
                           state VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT NOW(),
                           updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE pool_bet (
                          id UUID PRIMARY KEY,
                          pool_id UUID,
                          user_id UUID,
                          first_place UUID NOT NULL,
                          second_place UUID,
                          third_place UUID,
                          rated BOOLEAN,
                          points NUMERIC,
                          state VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT NOW(),
                          updated_at TIMESTAMP DEFAULT NOW()
);

ALTER TABLE pool_configuration
    ADD CONSTRAINT fk_poolconfig_pool
        FOREIGN KEY (pool_id) REFERENCES pool(id);

ALTER TABLE pool
    ADD CONSTRAINT fk_pool_config
        FOREIGN KEY (configuration_id) REFERENCES pool_configuration(id);

ALTER TABLE team
    ADD CONSTRAINT fk_team_pool
        FOREIGN KEY (pool_id) REFERENCES pool(id);

ALTER TABLE "user"
    ADD CONSTRAINT fk_user_pool
        FOREIGN KEY (pool_id) REFERENCES pool(id);

ALTER TABLE "match"
    ADD CONSTRAINT fk_match_pool
        FOREIGN KEY (pool_id) REFERENCES pool(id);

ALTER TABLE "match"
    ADD CONSTRAINT fk_match_home_team
        FOREIGN KEY (home_team) REFERENCES team(id);

ALTER TABLE "match"
    ADD CONSTRAINT fk_match_visitor_team
        FOREIGN KEY (visitor_team) REFERENCES team(id);

ALTER TABLE match_bet
    ADD CONSTRAINT fk_match_bet_pool
        FOREIGN KEY (pool_id) REFERENCES pool(id);

ALTER TABLE match_bet
    ADD CONSTRAINT fk_match_bet_match
        FOREIGN KEY (match_id) REFERENCES "match"(id);

ALTER TABLE match_bet
    ADD CONSTRAINT fk_match_bet_user
        FOREIGN KEY (user_id) REFERENCES "user"(id);

ALTER TABLE match_bet
    ADD CONSTRAINT fk_match_bet_winner_team
        FOREIGN KEY (winner_team_id) REFERENCES team(id);

ALTER TABLE pool_bet
    ADD CONSTRAINT fk_pool_bet_pool
        FOREIGN KEY (pool_id) REFERENCES pool(id);

ALTER TABLE pool_bet
    ADD CONSTRAINT fk_pool_bet_user
        FOREIGN KEY (user_id) REFERENCES "user"(id);

ALTER TABLE pool_bet
    ADD CONSTRAINT fk_pool_bet_first_place
        FOREIGN KEY (first_place) REFERENCES team(id);

ALTER TABLE pool_bet
    ADD CONSTRAINT fk_pool_bet_second_place
        FOREIGN KEY (second_place) REFERENCES team(id);

ALTER TABLE pool_bet
    ADD CONSTRAINT fk_pool_bet_third_place
        FOREIGN KEY (third_place) REFERENCES team(id);
