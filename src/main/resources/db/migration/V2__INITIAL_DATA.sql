-- Insert data into pool
INSERT INTO pool (id, name, starting_date, ending_date, phase, state, created_at, updated_at)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Pool A', '2025-01-01 00:00:00', '2025-12-31 23:59:59', 1, 'ACTIVE', NOW(), NOW()),
    ('22222222-2222-2222-2222-222222222222', 'Pool B', '2025-02-01 00:00:00', '2025-11-30 23:59:59', 1, 'ACTIVE', NOW(), NOW());

-- Insert data into pool_configuration
INSERT INTO pool_configuration (
    id, pool_id, champions_win_points, second_place_win_points, third_place_win_points,
    winner_team_win_points, draw_team_win_points, total_yellow_cards_win_points,
    total_red_cards_win_points, total_local_goals_win_points, total_visiting_goal_win_points
)
VALUES
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '11111111-1111-1111-1111-111111111111', 10, 7, 5, 3, 1, 2, 4, 6, 8),
    ('bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '22222222-2222-2222-2222-222222222222', 15, 10, 8, 4, 2, 3, 5, 7, 9);

-- Update pool to reference pool_configuration
UPDATE pool
SET configuration_id = 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa'
WHERE id = '11111111-1111-1111-1111-111111111111';

UPDATE pool
SET configuration_id = 'bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbbb'
WHERE id = '22222222-2222-2222-2222-222222222222';

-- Insert data into user: Password 1 is pass123, Password 2 is pass456
INSERT INTO "user" (
    id, pool_id, id_number, email, phone, age, name, nickname, password, photo,
    role, otp, points, state, created_at, updated_at
)
VALUES
    ('33333333-3333-3333-3333-333333333333', '11111111-1111-1111-1111-111111111111', 'ID1001', 'user1@example.com', '1234567890', 30, 'John Doe', 'johnny', '$2a$12$kbLJ/tIz7hreuDlQcCETc.kqb2WvQi/aJT.Ps6bKj8a1tfdo503q2', NULL, 'ADMIN', NULL, 0, 'ACTIVE', NOW(), NOW()),
    ('44444444-4444-4444-4444-444444444444', '22222222-2222-2222-2222-222222222222', 'ID1002', 'user2@example.com', '0987654321', 25, 'Jane Smith', 'janeS', '$2a$12$RvWCcRjQU6IB8l7z5RSW/uy3C/AZa9zkf99Cll4YGZ5sGeJTdhdIK', NULL, 'USER', NULL, 0, 'ACTIVE', NOW(), NOW());
