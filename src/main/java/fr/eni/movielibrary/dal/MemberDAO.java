package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO extends CrudRepository<Member, Integer> {
    Member findMemberByLogin(String login);
}
