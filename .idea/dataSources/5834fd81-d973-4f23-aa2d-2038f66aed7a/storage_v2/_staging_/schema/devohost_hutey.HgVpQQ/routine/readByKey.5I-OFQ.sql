create
    definer = devohost_hutey@`%` procedure getByLogin(IN user_Key varchar(50), OUT user_login varchar(30),
                                                      OUT user_pass varchar(30), OUT user_email varchar(30),
                                                      OUT user_phone varchar(15), out id int(11), out created_date timestamp)
begin
    select login into user_login from users where login = user_Key;
    select password into user_pass from users where login = user_Key;
    select email into user_email from users where login = user_Key;
    select phone into user_phone from users where login = user_Key;
    select user_id into id from users where login = user_Key;
    select created into  created_date from users where login = user_Key;

end;

