DROP DATABASE IF EXISTS dictionary;
CREATE DATABASE dictionary;

DROP TABLE IF EXISTS dictionary.admin;
CREATE TABLE dictionary.admin (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  username VARCHAR(255) NOT NULL
  COMMENT '用户名',
  password VARCHAR(255) NOT NULL
  COMMENT '密码'
)
  COMMENT '管理员';


DROP TABLE IF EXISTS dictionary.word;
CREATE TABLE dictionary.word (
  id         INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  english    VARCHAR(255) NOT NULL
  COMMENT '英文',
  phoneticUk VARCHAR(255)
  COMMENT '英语音标',
  phoneticUs VARCHAR(255)
  COMMENT '美语音标'
)
  COMMENT '单词表';

DROP TABLE IF EXISTS dictionary.pos;
CREATE TABLE dictionary.pos (
  id     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  pos    VARCHAR(255)
  COMMENT '词性',
  wordId INT COMMENT 'FK'
)
  COMMENT '词性表';

DROP TABLE IF EXISTS dictionary.concise;
CREATE TABLE dictionary.concise (
  id      INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  chinese VARCHAR(255) NOT NULL
  COMMENT '中文',
  posId   INT COMMENT 'FK'
)
  COMMENT '简明释义表';

DROP TABLE IF EXISTS dictionary.detail;
CREATE TABLE dictionary.detail (
  id     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  detail TEXT
  COMMENT '详尽释义',
  posId  INT COMMENT 'FK'
)
  COMMENT '详尽释义表';

DROP TABLE IF EXISTS dictionary.sentence;
CREATE TABLE dictionary.sentence (
  id      INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  english TEXT COMMENT '例句英文',
  chinese TEXT COMMENT '例句中文',
  posId   INT COMMENT 'FK'
)
  COMMENT '例句表';

-- fk
ALTER TABLE dictionary.pos
  ADD CONSTRAINT
  fk_pos_wordId
FOREIGN KEY (wordId)
REFERENCES dictionary.word (id)
  ON DELETE CASCADE;

ALTER TABLE dictionary.concise
  ADD CONSTRAINT
  fk_concise_posId
FOREIGN KEY (posId)
REFERENCES dictionary.pos (id)
  ON DELETE CASCADE;

ALTER TABLE dictionary.detail
  ADD CONSTRAINT
  fk_detail_posId
FOREIGN KEY (posId)
REFERENCES dictionary.pos (id)
  ON DELETE CASCADE;

ALTER TABLE dictionary.sentence
  ADD CONSTRAINT
  fk_sentence_posId
FOREIGN KEY (posId)
REFERENCES dictionary.pos (id)
  ON DELETE CASCADE;

-- SELECT
SELECT *
FROM dictionary.admin;
SELECT *
FROM dictionary.word;
SELECT *
FROM dictionary.pos;
SELECT *
FROM dictionary.concise;
SELECT *
FROM dictionary.detail;
SELECT *
FROM dictionary.sentence;

SELECT
  w.english,
  w.phoneticUk,
  w.phoneticUs,
  p.pos,
  c.chinese,
  d.detail,
  s.english,
  s.chinese
FROM dictionary.word w INNER JOIN dictionary.pos p
  INNER JOIN dictionary.concise c
  INNER JOIN dictionary.detail d
  INNER JOIN dictionary.sentence s
    ON w.id = p.wordId AND p.id = c.posId AND p.id = d.posId AND p.id = s.posId
WHERE w.english = 'test';