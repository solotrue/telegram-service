CREATE TABLE telegram_user (
  id BIGSERIAL PRIMARY KEY,
  chat_id BIGINT NOT NULL UNIQUE,
  username VARCHAR(255),
  active BOOLEAN NOT NULL,
  register_time TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE telegram_user_message (
  id BIGSERIAL PRIMARY KEY,
  chat_id BIGINT NOT NULL,
  message_text TEXT,
  time TIMESTAMP WITHOUT TIME ZONE,
  user_chat_id BIGINT NOT NULL,
  CONSTRAINT fk_telegram_user_message_telegram_user FOREIGN KEY (user_chat_id) REFERENCES telegram_user(chat_id) ON DELETE CASCADE
);

