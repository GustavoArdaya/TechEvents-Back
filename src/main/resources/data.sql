INSERT
INTO
  _events
  (title, description, _date, _time, max_participants,is_highlighted)
VALUES
  ('mc many to many1', '', '2023-05-14', current_time, 0,false),
  ('mc many to many2', '', '2023-04-23', current_time, 0,false),
  ('mc many to many3', '', '2023-06-21', current_time, 0,false),
  ('mc many to many4', '', '2023-03-05', current_time, 0,false);

INSERT
INTO
  user_events
  (event_id, user_id)
VALUES
  (1,1),
  (1,2),
  (2,1),
  (3,2);

