INSERT
INTO
  _events
  (id,title, description, _date, _time, max_participants)
VALUES
  (1,'mc many to many', '', current_date, current_time, 0);

INSERT
INTO
  user_events
  (event_id, user_id)
VALUES
  (1,1);

