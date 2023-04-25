INSERT
INTO
  _events
  (id,title, description, _date, _time, max_participants,is_highlighted)
VALUES
  (100,'mc many to many1', '', current_date, current_time, 0,false),
  (200,'mc many to many2', '', current_date, current_time, 0,false),
  (300,'mc many to many3', '', current_date, current_time, 0,false),
  (400,'mc many to many4', '', current_date, current_time, 0,false);


INSERT
INTO
  user_events
  (event_id, user_id)
VALUES
  (100,1),
  (100,2),
  (200,1),
  (300,2);

