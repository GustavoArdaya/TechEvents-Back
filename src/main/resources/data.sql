INSERT
INTO
  _events
  (id,title, description, _date, _time, max_participants,is_highlighted)
VALUES
  (1,'mc many to many1', '', current_date, current_time, 0,false),
  (2,'mc many to many2', '', current_date, current_time, 0,false),
  (3,'mc many to many3', '', current_date, current_time, 0,false),
  (4,'mc many to many4', '', current_date, current_time, 0,false);


INSERT
INTO
  user_events
  (event_id, user_id)
VALUES
  (1,1),
  (1,2),
  (2,1),
  (3,2);

