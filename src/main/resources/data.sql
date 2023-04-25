INSERT
INTO
  _events
  (id,title, description, _date, _time, max_participants,is_highlighted)
VALUES
  (100,'mc many to many1', '', '2023-05-14', current_time, 2,false),
  (200,'mc many to many2', '', '2023-04-23', current_time, 1,false),
  (300,'mc many to many3', '', '2023-06-21', current_time, 1,false),
  (400,'mc many to many4', '', '2023-03-05', current_time, 10,false);


INSERT
INTO
  user_events
  (event_id, user_id)
VALUES
  (100,1),
  (100,2),
  (200,1),
  (300,2);

