package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO extends JpaRepository<Member, Integer> {
    Member findMemberByLogin(String login);
    Member findMemberByLoginAndPassword(String login, String password);
}
